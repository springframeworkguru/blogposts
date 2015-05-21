package guru.springframework.blog.openclosedprinciple;

/**
 * Created by Admin on 5/21/2015.
 */
public class VehicleInsuranceSurveyor extends InsuranceSurveyor{
    public boolean isValidClaim(){
       System.out.println("VehicleInsuranceSurveyor: Validating vehicle insurance claim...");
        /*Logic to validate vehicle insurance claims*/
        return true;
    }

}
