package guru.springframework.blog.openclosedprinciple;

/**
 * Created by Admin on 5/21/2015.
 */
public class HealthInsuranceSurveyor extends InsuranceSurveyor{
    public boolean isValidClaim(){
        System.out.println("HealthInsuranceSurveyor: Validating health insurance claim...");
        /*Logic to validate health insurance claims*/
        return true;
    }

}
