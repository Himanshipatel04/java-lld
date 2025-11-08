package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

interface IChannel {
    void subscribe(Subscriber subs);

    void unsubscribe(ISubscriber subs);

    void notifySubs();

    void addVideo(Video v);

    void removeVideo(Video v);
}

interface ISubscriber {
    void update();
}

class Subscriber implements ISubscriber {
    String name;
    int id;
    Channel channel;

    Subscriber(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void update() {
        System.out.println("Hey " + name + ", new video added on channel " + channel.name);
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

}

class Video {
    int id;
    String name;
    int duration;
    String description;

    public Video(int id,
            String name,
            int duration,
            String description) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.description = description;
    }
}

class Channel implements IChannel {
    public String name;
    int id;
    List<ISubscriber> subscribers = new ArrayList<>();
    List<Video> videos = new ArrayList<>();

    public Channel(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void subscribe(Subscriber sub) {
        subscribers.add(sub);
        sub.setChannel(this);
    }

    public void unsubscribe(ISubscriber sub) {
        subscribers.remove(sub);
    }

    public void uploadVideo(String title) {
        System.out.println("\n[" + name + " uploaded \"" + title + "\"]");
        notifySubs();
    }

    public String getVideoData() {
        return "\nCheckout our new Video : " + "\n";
    }

    public void notifySubs() {
        for (ISubscriber s : subscribers) {
            s.update();
        }
    }

    public void addVideo(Video video) {
        videos.add(video);
        notifySubs();
    }

    public void removeVideo(Video video) {
        videos.remove(video);
    }

}

public class Observer {
    public static void main(String[] args) {
        Channel techChannel = new Channel("TechVerse", 1);
        Subscriber s1 = new Subscriber("Himanshi", 101);

        Subscriber s2 = new Subscriber("Prince", 102);

        techChannel.subscribe(s1);
        techChannel.subscribe(s2);

        Video v1 = new Video(1, "Observer Pattern Explained", 10, "Learn the Observer Design Pattern");
        techChannel.addVideo(v1);
    }
}
