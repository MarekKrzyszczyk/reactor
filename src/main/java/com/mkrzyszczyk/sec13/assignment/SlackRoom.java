package com.mkrzyszczyk.sec13.assignment;

import com.mkrzyszczyk.sec13.assignment.SlackMember;
import com.mkrzyszczyk.sec13.assignment.SlackMessage;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SlackRoom {

    private final String name;
    private final Sinks.Many<SlackMessage> sink;
    private final Flux<SlackMessage> flux;

    public SlackRoom(String name) {
        this.name = name;
        this.sink = Sinks.many().replay().all();
        this.flux = sink.asFlux();
    }

    public void joinRoom(SlackMember slackMember) {
        System.out.println(slackMember.getName() + " ------------ joined ------------ " + name);
        this.subscribe(slackMember);
        slackMember.setMessageConsumer(message -> postMessage(message, slackMember));
    }

    private void subscribe(SlackMember slackMember) {
        flux
                .filter(message -> !message.getSender().equals(slackMember.getName()))
                .doOnNext(slackMessage -> slackMessage.setReceiver(slackMember.getName()))
                .map(SlackMessage::toString)
                .subscribe(slackMember::receives);
    }

    private void postMessage(String message, SlackMember slackMember) {
        SlackMessage slackMessage = new SlackMessage();
        slackMessage.setSender(slackMember.getName());
        slackMessage.setMessage(message);
        sink.tryEmitNext(slackMessage);
    }
}
