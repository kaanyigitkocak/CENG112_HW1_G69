import java.util.Random;

public class GarbageRecyclingApp {

	public static void main(String[] args) {

		FileIO file = new FileIO();
		file.readTrashCan();

		TrashCan<Garbage> trashCan = (TrashCan<Garbage>) file.readTrashCan();
		PlasticRecycleBin<Garbage> plasticRecycleBin = new PlasticRecycleBin<Garbage>();
		FabricRecycleBin<Garbage> fabricRecycleBin = new FabricRecycleBin<Garbage>();
		MetalRecycleBin<Garbage> metalRecycleBin = new MetalRecycleBin<Garbage>();
		PaperRecycleBin<Garbage> paperRecycleBin = new PaperRecycleBin<Garbage>();
		OrganicRecycleBin<Garbage> organicRecycleBin = new OrganicRecycleBin<Garbage>();
		GlassRecycleBin<Garbage> glassRecycleBin = new GlassRecycleBin<Garbage>();



		for( int i = 1; i<= trashCan.getItemCount() ;i++) {

			trashCan.separate(trashCan.getByIndex(i),metalRecycleBin,glassRecycleBin,organicRecycleBin,paperRecycleBin,plasticRecycleBin,fabricRecycleBin);
		}

//		System.out.println(plasticRecycleBin.displayItems());
//		System.out.println(organicRecycleBin.getItemCount());
//		System.out.println(metalRecycleBin.getItemCount());
//		System.out.println(fabricRecycleBin.getItemCount());
//		System.out.println(glassRecycleBin.getItemCount());
//		System.out.println(paperRecycleBin.getItemCount());




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
