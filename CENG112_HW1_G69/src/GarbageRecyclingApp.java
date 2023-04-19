import java.util.Random;

public class GarbageRecyclingApp {

	public static void main(String[] args) {

		FileIO file = new FileIO();
		file.readTrashCan();

		TrashCan<Garbage> trashCan = (TrashCan<Garbage>) file.readTrashCan();

		IBag<Garbage> plasticRecycleBin = new PlasticRecycleBin<Garbage>();
		IBag<Garbage> fabricRecycleBin = new FabricRecycleBin<Garbage>();
		IBag<Garbage> metalRecycleBin = new MetalRecycleBin<Garbage>();
		IBag<Garbage> paperRecycleBin = new PaperRecycleBin<Garbage>();
		IBag<Garbage> organicRecycleBin = new OrganicRecycleBin<Garbage>();
		IBag<Garbage> glassRecycleBin = new GlassRecycleBin<Garbage>();

		System.out.println("The Trash Can: "+trashCan.getItemCount()+ " size and content");
		trashCan.displayItems();
		System.out.println();

		for( int i = 1; i<= trashCan.getItemCount() ;i++) {
			trashCan.separate(trashCan.getByIndex(i),metalRecycleBin,glassRecycleBin,organicRecycleBin,paperRecycleBin,plasticRecycleBin,fabricRecycleBin);
		}

		file.updateTrashCan(trashCan);

		System.out.println("Plastic Recycling Bin (" + plasticRecycleBin.getItemCount() + " items):");
		plasticRecycleBin.displayItems();
		System.out.println();

		System.out.println("Fabric Recycling Bin (" + fabricRecycleBin.getItemCount() + " items):");
		fabricRecycleBin.displayItems();
		System.out.println();

		System.out.println("Metal Recycling Bin (" + metalRecycleBin.getItemCount() + " items):");
		metalRecycleBin.displayItems();
		System.out.println();

		System.out.println("Paper Recycling Bin (" + paperRecycleBin.getItemCount() + " items):");
		paperRecycleBin.displayItems();
		System.out.println();

		System.out.println("Organic Recycling Bin (" + organicRecycleBin.getItemCount() + " items):");
		organicRecycleBin.displayItems();
		System.out.println();

		System.out.println("Glass Recycling Bin (" + glassRecycleBin.getItemCount() + " items):");
		glassRecycleBin.displayItems();
		System.out.println();


		System.out.println("The Updated Trash Can: "+trashCan.getItemCount()+ " size and content");
		trashCan.displayItems();

		//for check dump method
		//trashCan.dump();
		//System.out.println("The Trash Can: "+trashCan.getItemCount()+ " size and content");
		//trashCan.displayItems();
	}

}
