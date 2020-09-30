package libnoiseforjava.util;

import java.util.GregorianCalendar;
import java.util.Random;

public class GenRandomRolls {
	protected class GenCalendar extends GregorianCalendar{
	    public GenCalendar(){
	        super();
	    }

	    public long getGenTimeInMillis(){
	        return getTimeInMillis();
	    }
	}
	
	private GenCalendar calendar;
    private long seed_random;
    private static Random random;
    
    private static GenRandomRolls instance = new GenRandomRolls();
    
    //singleton 
    
    /**
     * 
     * @return single instance of GenRandomRolls
     */
    public static GenRandomRolls Instance(){
    	return instance;
    }
    
    /**
     * construction
     */
    public GenRandomRolls(){
        calendar = new GenCalendar();
        this.seed_random = calendar.getGenTimeInMillis();
        random = new Random(this.seed_random);
    }

    /**
     * construction with seed
     * @param - long seed 
     */
    public GenRandomRolls(long seed_random){
        this.seed_random = seed_random;
        random = new Random(this.seed_random);
    }

    /**
     * @param ip_int
     * @return int between 0 and ip_real
     */

    public int getDraw(double ip_real){
	return (int)(random.nextDouble() * ip_real);
    }
    public Double  getDraw(Double ip_real){
	return random.nextDouble() * ip_real;
    }

    /**
     *
     */
    public double draw_rand(){return random.nextDouble();}
    
    public Double getAngle(){
    	return getDraw(new Double(360.0));
    }

    /**
    *
    * 
    * @return - integer between 0 and 99
    */
   public int getD100(){
       return getDraw(100.0);
   }

   /**
    *
    * 
    * @return - integer between 0 and 999
    */
   public int getD1000(){
       return getDraw(1000.0);
   }

   /**
    *
    * 
    * @return - integer between 0 and 4499
    */
   public int getD4500(){
       return getDraw(4500.0);
   }
   
   public int getD100000(){
   	return getDraw(100000.0);
   }
   
   public int getD250000(){
	   return getDraw(250000.0);
   }
   /**
    * 
    * @param x
    * @return value based on x
    */
   public int getDX(Integer x){
	   return getDraw(new Double(x).doubleValue());
   }
   /**
    * 
    * @return random angle
    */
	public double getD360() {
		return getDraw(360.0);
	}
	
	/**
	 * 
	 * @return draw less than 50%
	 */
	public double getD49(){
		return getDraw(49.00);
	}

   /**
    * @return - integer between 0 an 3
    */
   public int getD3(){return getDraw(3.0);}
   
   /**
    * numbers between 1 and n
    */
   public int get_D3(){return getDraw(3.0) + 1;}
   public int get_D2(){return getDraw(2.0) + 1;}
   public int get_D4(){return getDraw(4.0) + 1;}
   public int get_D6(){return getDraw(6.0) + 1;}
   public int get_D8(){return getDraw(8.0) + 1;}
   public int get_D9(){return getDraw(9.0) + 1;}
   public int get_D10(){return getDraw(10.0) + 1;}
   public int get_D10zero(){return getDraw(10.0);}
   public int get_D18(){return getDraw(18.0) + 1;}



}
