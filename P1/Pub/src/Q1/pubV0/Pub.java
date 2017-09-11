package Q1.pubV0;

import java.util.*;

public class Pub {

/*
 * atributos com acessabilidade publica. Isso eh ruim.
    public static final String ONE_BEER = "hansa";
    public static final String ONE_CIDER = "grans";
    public static final String A_PROPER_CIDER = "strongbow";
    public static final String GT = "gt";
    public static final String BACARDI_SPECIAL = "bacardi_special";
*/
	/*
	 * Mudanca de acessabilidade para privado.
	 * Mantemos essas strings para facilitar na compararcao
	 * E caso queira mudar a string do drink fica mais facil assim.
	 */
	private static final String ONE_BEER = "hansa";
	private static final String ONE_CIDER = "grans";
	private static final String A_PROPER_CIDER = "strongbow";
	private static final String GT = "gt";
	private static final String BACARDI_SPECIAL = "bacardi_special";
	private List<drink> _armazem = new ArrayList<drink>();
	
	/*
	 * Q3a
	 * criacao de classe drink para guarda nome e preco (price)
	 * mudando para armazenar os objetos drink numa lista
	 * lista com os drinks eh privada
	 * lista com os drinks eh inicializa no construtor
	 */
	
	/*
	 * criacao de um construtor para inicializar os atributos.
	 */
	public Pub() {
		_armazem = montarArmazem();
	}
	
	/*
	 * Criacao de um metodo para montar a lista de drinks
	 */
	private List<drink> montarArmazem() {
		
		List<drink> armazemMontado = new ArrayList<drink>();
		drink hansa = new drink("hansa",74);
		drink grans = new drink("grans",103);
		drink strongbow = new drink("strongbow",110);
		int priceGT = ingredient6() + ingredient5() + ingredient4();
		drink gt = new drink("gt",priceGT);
		int pricebacardi = ingredient6() + ingredient1() + ingredient2() + ingredient3();
		drink bacardi = new drink("bacardi_special",pricebacardi);
		armazemMontado.add(hansa);
		armazemMontado.add(grans);
		armazemMontado.add(strongbow);
		armazemMontado.add(gt);
		armazemMontado.add(bacardi);
		return armazemMontado;
	}
    public int computeCost(String drink, boolean student, int amount) {
    	/*
    	 * Q3a
    	 * criacao de classe drink para guarda nome e preco (price)
    	 * mudando para armazenar os objetos drink numa lista
    	 * lista com os drinks eh privada
    	 * lista com os drinks eh inicializa no construtor
    	 */
    	drink MyDrink = null;
    	int price;
    	for(drink cup:_armazem) {
    		if(cup.getName() == drink) {
    			MyDrink = new drink(drink,cup.getPrice());
    		}
    	}
    	if(amount >2 && (MyDrink.getName() == GT || MyDrink.getName() == BACARDI_SPECIAL)) {
    		throw new RuntimeException("Too many drinks, max 2.");
    	}
    	if(MyDrink != null) {
    		price = MyDrink.getPrice();
    	}
    	else {
    		throw new RuntimeException("No such drink exists");
    	}
    	if (student && (MyDrink.getName() == ONE_CIDER || MyDrink.getName() == ONE_BEER || MyDrink.getName() == A_PROPER_CIDER)) {
    		 price = price - price/10;
    	}
    	
    	/*
    	 * Muitos if e else case
    	 * dificil de enteder os diversos caminhos derivados disso.
        if (amount > 2 && (drink == armazem. GT || drink == BACARDI_SPECIAL)) {
            throw new RuntimeException("Too many drinks, max 2.");
        }
        int price;
        if (drink.equals(ONE_BEER)) {
            price = 74;
        }
        else if (drink.equals(ONE_CIDER)) {
            price = 103;
        }
        else if (drink.equals(A_PROPER_CIDER)) price = 110;
        else if (drink.equals(GT)) {
            price = ingredient6() + ingredient5() + ingredient4();
        }
        else if (drink.equals(BACARDI_SPECIAL)) {
            price = ingredient6() + ingredient1() + ingredient2() + ingredient3();
        }
        else {
            throw new RuntimeException("No such drink exists");
        }
        if (student && (drink == ONE_CIDER || drink == ONE_BEER || drink == A_PROPER_CIDER)) {
            price = price - price/10;
        }
        */
        return price*amount;
    }

    //one unit of rum
    private int ingredient1() {
        return 65;
    }

    //one unit of grenadine
    private int ingredient2() {
        return 10;
    }

    //one unit of lime juice
    private int ingredient3() {
        return 10;
    }

    //one unit of green stuff
    private int ingredient4() {
        return 10;
    }

    //one unit of tonic water
    private int ingredient5() {
        return 20;
    }

    //one unit of gin
    private int ingredient6() {
        return 85;
    }
}
