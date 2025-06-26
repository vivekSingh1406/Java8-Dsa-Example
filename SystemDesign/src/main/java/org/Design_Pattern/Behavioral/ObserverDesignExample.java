package org.Design_Pattern.Behavioral;

import java.util.ArrayList;
import java.util.List;


interface Subscriber {
    void notifyNewVideo(String videoTitle);
}


interface Channel {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifyAllSubscribers(String videoTitle);
}

class YouTubeChannel implements Channel {
    private List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifyAllSubscribers(String videoTitle) {
        for (Subscriber subscriber : subscribers) {
            subscriber.notifyNewVideo(videoTitle);
        }
    }

    public void uploadVideo(String videoTitle) {
        System.out.println("YouTubeChannel: Uploaded new video -> " + videoTitle);
        notifyAllSubscribers(videoTitle);
    }
}


class YouTubeUser implements Subscriber {
    private String username;

    public YouTubeUser(String username) {
        this.username = username;
    }

    @Override
    public void notifyNewVideo(String videoTitle) {
        System.out.println(username + " got notified: New video - " + videoTitle);
    }
}

public class ObserverDesignExample {

    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();

        Subscriber vivek = new YouTubeUser("Vivek");
        Subscriber amit = new YouTubeUser("Amit");

        channel.subscribe(vivek);
        channel.subscribe(amit);

        channel.uploadVideo("Observer Design Pattern Explained");
        channel.uploadVideo("Java Interview Questions");
    }
}
