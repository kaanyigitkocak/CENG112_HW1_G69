import java.util.Random;

public class GarbageRecyclingApp {

	public static void main(String[] args) {

		FileIO file = new FileIO();
		file.readTrashCan();

		TrashCan<Garbage> trashCan = (TrashCan<Garbage>) file.readTrashCan();
		System.out.println("The Trash Can: "+trashCan.getItemCount()+ " size and content");
		trashCan.displayItems();

		PlasticRecycleBin<Garbage> plasticRecycleBin = new PlasticRecycleBin<Garbage>();
		FabricRecycleBin<Garbage> fabricRecycleBin = new FabricRecycleBin<Garbage>();
		MetalRecycleBin<Garbage> metalRecycleBin = new MetalRecycleBin<Garbage>();
		PaperRecycleBin<Garbage> paperRecycleBin = new PaperRecycleBin<Garbage>();
		OrganicRecycleBin<Garbage> organicRecycleBin = new OrganicRecycleBin<Garbage>();
		GlassRecycleBin<Garbage> glassRecycleBin = new GlassRecycleBin<Garbage>();

		for( int i = 1; i<= trashCan.getItemCount() ;i++) {
			trashCan.separate(trashCan.getByIndex(i),metalRecycleBin,glassRecycleBin,organicRecycleBin,paperRecycleBin,plasticRecycleBin,fabricRecycleBin);
		}


		System.out.println("Plastic Recycling Bin: "+plasticRecycleBin.getItemCount()+ " size and content");
		plasticRecycleBin.displayItems();

		System.out.println("Fabric Recycling Bin: "+fabricRecycleBin.getItemCount()+ " size and content");
		fabricRecycleBin.displayItems();

		System.out.println("Metal Recycling Bin: "+metalRecycleBin.getItemCount()+ " size and content");
		metalRecycleBin.displayItems();

		System.out.println("Paper Recycling Bin: "+paperRecycleBin.getItemCount()+ " size and content");
		paperRecycleBin.displayItems();

		System.out.println("Organic Recycling Bin: "+organicRecycleBin.getItemCount()+ " size and content");
		organicRecycleBin.displayItems();

		System.out.println("Glass Recycling Bin: "+glassRecycleBin.getItemCount()+ " size and content");
		glassRecycleBin.displayItems();





		//while(!plasticRecycleBin.isFull()) {
		//	System.out.println(plasticRecycleBin.getItemCount());
		//	trashCan.separate(garbage3, plasticRecycleBin);
		//}



		//trashCan.remove();
		//System.out.println(trashCan.getItemCount());
		//System.out.println(plasticRecycleBin.getItemCount());
		//trashCan.displayItems();
		//plasticRecycleBin.displayItems();




	}

}
