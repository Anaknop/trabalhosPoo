package youtube;

public class Inscrição implements IInscrição {
	private String notification;
	private String name;
	
	public Inscrição(String name) {
		this.name = name;
	}

	@Override
	public void newVideoAdded(String channelName, Videos video) {
		this.notification = "Olá "+ this.name+"!"+ " novo vídeo " + video.getTitle() + " do canal " + channelName + " confira!";
		System.out.println(notification);
	}
	
}
