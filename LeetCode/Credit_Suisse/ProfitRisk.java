import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;

public class ProfitRisk {
    private static DecimalFormat df = new DecimalFormat("#.00");
    public static void main(String[] args) {
        int n = 4;
        int m = 2;
        Double probability[] = new Double[]{0.50, 0.50, 0.50, 0.50};
        Double profit[] = new Double[]{4.00, 1.00, 2.00, 3.00};
        Double loss[] = new Double[]{4.00, 0.50, 1.00, 1.00};
        Double total[] = new Double[probability.length];
        for(int i=0; i<probability.length; i++){
            total[i] = probability[i]*profit[i] - (1-probability[i])*loss[i];
        }
        String s  =calculateProfit(m, total);
        System.out.println(Double.parseDouble(s));
        System.out.println(Double.parseDouble(s) == 1.5000);
    }
    static String calculateProfit(int m, Double total[]){
        Arrays.sort(total, Collections.reverseOrder());
        System.out.println(Arrays.toString(total));
        Double sum = 0.0d;

        for(int x=0; x<m;x++){
            if(total[x] < 0) break;
            sum += total[x];
        }
        return new DecimalFormat("#.##").format(sum);
    }
}
