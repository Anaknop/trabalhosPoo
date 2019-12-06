package youtube;

import java.util.ArrayList;
import java.util.List;

public class Canal implements ICanal {
	private List<Inscrição> inscriçãos;
	private List<Videos> videos;
	private String name;
	
	public Canal(String name) {
		this.name = name;
		inscriçãos = new ArrayList();
		videos = new ArrayList();
	}
	
	public void addVideo(String videoName) {
		Videos video = new Videos(videoName);
		videos.add(video);
		notifySubscriber(video);
	}
	
	@Override
	public void subscribeToChannel(Inscrição sub) {
		inscriçãos.add(sub);
	}

	@Override
	public void unfollowChannel(Inscrição sub) {
		inscriçãos.remove(sub);
	}

	@Override
	public void notifySubscriber(Videos video) {
		for(Inscrição subs: inscriçãos) {
			subs.newVideoAdded(this.name, video);
		}
		
	}
}
