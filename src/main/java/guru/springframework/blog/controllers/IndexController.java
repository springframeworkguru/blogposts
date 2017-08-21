package guru.springframework.blog.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@RestController
@RequestMapping("/home")
public class IndexController {

    /*@RequestMapping at method level*/
    @RequestMapping("/index")
    String index(){
        return "Hello from index";
    }
    @RequestMapping(value={"", "/page", "page*","view/*"})
    String indexMultipleMapping(){
       return "Hello from index multiple mapping.";
   }

    /*@RequestMapping using HTTP request methods*/
     @RequestMapping(method = RequestMethod.GET)
    String get(){
        return "Hello from get";
    }
    @RequestMapping(method = RequestMethod.DELETE)
    String delete(){
        return "Hello from delete";
    }
    @RequestMapping(method = RequestMethod.POST)
    String post(){
        return "Hello from post";
    }
    @RequestMapping(method = RequestMethod.PUT)
    String put(){
        return "Hello from put";
    }
    @RequestMapping(method = RequestMethod.PATCH)
    String patch(){
        return "Hello from patch";
    }
    /*@RequestMapping with headers*/
    @RequestMapping(value = "/head", headers = {"content-type=text/plain", "content-type=text/html"})
    String getWithHeaders(){
        return "Mapping applied along with headers";
    }

    /*@RequestMapping with @RequestParam*/
    @RequestMapping(value = "/personId")
    String getId(@RequestParam String personId){
        System.out.println("ID is "+personId);
        return "Get ID from query string of URL without value element";
    }
    @RequestMapping(value = "/id")
    String getIdByValue(@RequestParam("id") String personId){
        System.out.println("ID is "+personId);
        return "Get ID from query string of URL with value element";
    }

    @RequestMapping(value = "/name")
    String getName(@RequestParam(value = "person", required = false) String personName ){
        return "Required element of request param";
    }

    /*@RequestMapping with produces and consumes attributes*/
    @RequestMapping(value = "/prod", produces = {"text/html", "application/JSON"})
    @ResponseBody
    String getProduces(){
        return "Produces attribute";
    }

    @RequestMapping(value = "/cons", consumes = {"text/plain", "application/XML"})
    String getConsumes(){
        return "Consumes attribute";
    }

    /*@RequestMapping with @PathVariable for Dynamic URI */
    @RequestMapping(value = "/fetch/{id}", method = RequestMethod.GET)
    String getDynamicUriValue(@PathVariable String id){
        System.out.println("ID is "+id);
        return "Dynamic URI parameter fetched";
    }
    @RequestMapping(value = "/fetch/{id:[a-z]+}/{name}", method = RequestMethod.GET)
    String getDynamicUriValueRegex(@PathVariable("name") String name){
        System.out.println("Name is "+name);
        return "Dynamic URI parameter fetched using regex";
    }

    /*@RequestMapping with params attribute*/
    @RequestMapping(value = "/fetch", params = {"personId=10"})
    String getParams(@RequestParam("personId") String id){
        return "Fetched parameter using params attribute = "+id;
    }

    @RequestMapping(value = "/fetch", params = {"personId=20"})
    String getParamsDifferent(@RequestParam("personId") String id){
        return "Fetched parameter using params attribute = "+id;
    }

    /*@RequestMapping for default method*/
    @RequestMapping()
    String defaultMethod(){
        return "This is a default method for the class";
    }

    /*@RequestMapping shortcuts*/
    @GetMapping("/person")
    public @ResponseBody ResponseEntity<String> getPerson() {
        return new ResponseEntity<String>("Response from GET", HttpStatus.OK);
    }

    @GetMapping("/person/{id}")
    public @ResponseBody ResponseEntity<String> getPersonById(@PathVariable String id){
        return new ResponseEntity<String>("Response from GET with id " + id, HttpStatus.OK);
    }

    @PostMapping("/person/post")
    public @ResponseBody ResponseEntity<String> postPerson() {
        return new ResponseEntity<String>("Response from POST method", HttpStatus.OK);
    }

    @PutMapping("/person/put")
    public @ResponseBody ResponseEntity<String> putPerson() {
        return new ResponseEntity<String>("Response from PUT method", HttpStatus.OK);
    }

    @DeleteMapping("/person/delete")
    public @ResponseBody ResponseEntity<String> deletePerson() {
        return new ResponseEntity<String>("Response from DELETE method", HttpStatus.OK);
    }

    @PatchMapping("/person/patch")
    public @ResponseBody ResponseEntity<String> patchPerson() {
        return new ResponseEntity<String>("Response from PATCH method", HttpStatus.OK);
    }
}