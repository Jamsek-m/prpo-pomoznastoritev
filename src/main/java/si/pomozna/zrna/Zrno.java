package si.pomozna.zrna;

import si.pomozna.model.Lokacija;
import si.pomozna.model.Storitev;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@ApplicationScoped
public class Zrno {

	private List<Storitev> storitve;
	
	@PostConstruct
	private void init(){
		String zacetek = "December 9, 2017";
		String konec = "December 18, 2017";
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		Date zac_dat = null;
		Date kon_dat = null;
		try {
			zac_dat = format.parse(zacetek);
			kon_dat = format.parse(konec);
		} catch(ParseException e){
			e.printStackTrace();
		}
		
		storitve = new ArrayList<Storitev>();
		
		storitve.add(new Storitev(1, zac_dat, kon_dat));
		
		storitve.add(new Storitev(2, new Lokacija("46.050380", "14.468966", 490.0)));
	}
	
	public List<Storitev> vrniVse(){
		return this.storitve;
	}
	
	public Storitev vrniEno(long id){
		for(Storitev storitev : this.storitve){
			if(storitev.getId() == id){
				return storitev;
			}
		}
		return null;
	}
	
	public long dodajStoritev(Storitev storitev){
		storitev.setId(storitve.size() + 1);
		storitve.add(storitev);
		return storitev.getId();
	}

}
