package celestia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

public class PeriodTest {
	
	private static Logger logger = Logger.getLogger(PeriodTest.class);

	/*
	 * from the data base
	 * 
|         5799950.4976059515 |
|          7808904.558027248 |
|           8544901.59391457 |
|          9524878.429012932 |
|          9541300.734916361 |
|          9552383.293532373 |
|          9606873.909865556 |
|           9631313.21242701 |
|          9669452.948028574 |
|          9706313.014653586 |
|          9735945.968605088 |
|           9760512.45813181 |
|          9782093.587728657 |
|          9796110.962512385 |
|          9860159.898588922 |
|          9924485.481515177 |
|          9954136.909229623 |
|         10029089.348038161 |
|         10089092.177860025 |
|         10163194.187406955 |
|          10353984.96047958 |
|         10439110.584879568 |
|          999956386.3686727 |
|          999997919.7425945 |
|          4995738210.737964 |
|           4995762967.56054 |
|          4995944951.504201 |
|          4996105236.169169 |
|          4996207313.072542 |
|          4996571463.318819 |
|          4997224907.149311 |
|          4997239352.131378 |
|          4997284127.457518 |
|          4997314371.961086 |
|          4998326459.830675 |
|          4998545125.207241 |
|          4998992551.656804 |
|         4999046407.0827875 |
|          4999105847.356906 |
|           4999378089.28115 |
|          4999588865.467336 |
|          4999904248.993748 |
|          5000446646.030817 |
|          5000451651.126807 |
|          5000523857.210126 |
|          5000761327.739171 |
|          5000848089.526964 |
|          5001110230.994341 |
|          5001440531.391906 |
|          5001441964.341121 |
|          5001577131.283122 |
|          5001634715.337989 |
|         5001997970.4818125 |
|          5002539986.612268 |
|          5003016803.457652 |
|          5003119818.964345 |
|          5003166533.184141 |
|           5003331176.80443 |
|          5003442990.594422 |
|          5003603921.082027 |
|          5004748554.112846 |
|            5004787780.1942 |

	 */

	static private List<Double> distances = new ArrayList<Double>();
	static{
			  distances.add(5799950.4976059515);
			  distances.add(7808904.558027248);
			  distances.add(8544901.59391457);
			  distances.add(9524878.429012932);
			  distances.add(9541300.734916361);
			  distances.add(9552383.293532373);
			  distances.add(9606873.909865556);
			  distances.add(9631313.21242701);
			  distances.add(9669452.948028574);
			  distances.add(9706313.014653586);
			  distances.add(9735945.968605088);
			  distances.add(9760512.45813181);
			  distances.add(9782093.587728657);
			  distances.add(9796110.962512385);
			  distances.add(9860159.898588922);
			  distances.add(9924485.481515177);
			  distances.add(9954136.909229623);
			  distances.add(10029089.348038161);
			  distances.add(10089092.177860025);
			  distances.add(10163194.187406955);
			  distances.add(10353984.96047958);
			  distances.add(10439110.584879568);
			  distances.add(999956386.3686727);
			  distances.add(999997919.7425945);
			  distances.add(4995738210.737964);
			  distances.add(4995762967.56054);
			  distances.add(4995944951.504201);
			  distances.add(4996207313.072542);
			  distances.add(4996571463.318819);
			  distances.add(4997224907.149311);
			  distances.add(4997239352.131378);
			  distances.add(4997284127.457518);
			  distances.add(4997314371.961086);
			  distances.add(4998326459.830675);
			  distances.add(4998545125.207241);
			  distances.add(4998992551.656804);
			  distances.add(4999046407.0827875);
			  distances.add(4999105847.356906);
			  distances.add(4999378089.28115);
			  distances.add(4999588865.467336);
			  distances.add(4999904248.993748);
			  distances.add(5000446646.030817);
			  distances.add(5000451651.126807);
			  distances.add(5000523857.210126);
			  distances.add(5000761327.739171);
			  distances.add(5000848089.526964);
			  distances.add(5001110230.994341);
			  distances.add(5001440531.391906);
			  distances.add(5001441964.341121);
			  distances.add(5001577131.283122);
			  distances.add(5001634715.337989);
			  distances.add(5001997970.4818125);
			  distances.add(5002539986.612268);
			  distances.add(5003016803.457652);
			  distances.add(5000446646.030817);
			  distances.add(5000451651.126807);
			  distances.add(5000523857.210126);
			  distances.add(5000761327.739171);
			  distances.add(5000848089.526964);
			  distances.add(5001110230.994341);
			  distances.add(5001440531.391906);
			  distances.add(5001441964.341121);
			  distances.add(5001577131.283122);
			  distances.add(5001634715.337989);
			  distances.add(5001997970.4818125);
			  distances.add(5002539986.612268);
			  distances.add(5003016803.457652);
			  distances.add(5003119818.964345);
			  distances.add(5003166533.184141);
			  distances.add(5003331176.80443);
			  distances.add(5003442990.594422);
			  distances.add(5003603921.082027);
			  distances.add(5004748554.112846);
			  distances.add(5004787780.1942);

	}

	@Test
	public void period_test() {
		for(Double distance : distances){
			Double period = Period.build(distance);
			logger.info("period:" + period + " for distance:" + distance);
		}
	}

}
