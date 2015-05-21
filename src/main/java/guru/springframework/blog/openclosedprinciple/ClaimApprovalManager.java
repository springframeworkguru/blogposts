package guru.springframework.blog.openclosedprinciple;

/**
 * Created by Admin on 5/21/2015.
 */
public class ClaimApprovalManager {
    public void processClaim(InsuranceSurveyor surveyor){
        if(surveyor.isValidClaim()){
            System.out.println("ClaimApprovalManager: Valid claim. Currently processing claim for approval....");
        }
    }

}
