import java.util.Random;

public class GarbageRecyclingApp {

	public static void main(String[] args) {

		Garbage garbage = new Garbage("asdasd", "plastic",3);
		TrashCan<Garbage> trashCan = new TrashCan<Garbage>();
		PlasticRecycleBin<Garbage> plasticRecycleBin = new PlasticRecycleBin<Garbage>();
		MetalRecycleBin<Garbage> metalRecycleBin = new MetalRecycleBin<Garbage>();
		PaperRecycleBin<Garbage> paperRecycleBin = new PaperRecycleBin<Garbage>();
		OrganicRecycleBin<Garbage> organicRecycleBin = new OrganicRecycleBin<Garbage>();
		GlassRecycleBin<Garbage> glassRecycleBin = new GlassRecycleBin<Garbage>();
		trashCan.add(garbage);
		trashCan.separate(garbage,plasticRecycleBin);
		System.out.println(plasticRecycleBin.contains(garbage));
		plasticRecycleBin.displayItems();

	}

}
