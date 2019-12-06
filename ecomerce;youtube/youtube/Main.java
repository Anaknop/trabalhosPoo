package youtube;

public class Main {

	public static void main(String[] args) {
		Canal canal = new Canal("MVMM");
		Inscrição alguem = new Inscrição("alguem");
		Inscrição outro = new Inscrição("outro");
		Inscrição maisum = new Inscrição("maisum");
		canal.subscribeToChannel(alguem);
		canal.subscribeToChannel(outro);
		canal.subscribeToChannel(maisum);

		canal.addVideo("Como mudar a senha de seu roteador Wi-Fi!?");
		
	}

}
