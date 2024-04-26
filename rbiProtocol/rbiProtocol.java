package Task06Bank2404.rbiProtocol;
import java.util.HashMap;
import java.util.Map;

public interface rbiProtocol {
    String country = "India";
    Map<String,String> bankCodes = new HashMap<>(Map.of("sbi","SBI0000", "hdfc","HDFC0000", "demat","DEMAT0000"));
    Map<String,String> sbiBranchCodes = new HashMap<>(Map.of("nashik","01", "pune","02", "mumbai","09"));
    Map<String,String> hdfcBranchCodes = new HashMap<>(Map.of("nashik","11", "pune","12", "mumbai","19"));
    Map<String,String> dematBranchCodes = new HashMap<>(Map.of("nashik","91", "pune","92", "mumbai","99"));
    String contactCode = "+91";

    boolean setUserDetails();
    void setBankDetails();
    boolean withdrawAmount();
    boolean depositeAmount();
    void showDetails();
    
}
