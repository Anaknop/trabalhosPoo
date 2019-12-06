package youtube;

public interface ICanal {
	void subscribeToChannel(Inscrição sub);
	void unfollowChannel(Inscrição sub);
	void notifySubscriber(Videos video);
}
