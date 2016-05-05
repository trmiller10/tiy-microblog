import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

public class Main {

    public static void main(String[] args) {

        // this creates an end-point for the webroot
        Spark.get(
                "/",
                (request, response) -> {
                    // create a HashMap to hold our model

                    // check if the session contains an element with a key "user"

                        // IF SO:
                        // get the user from the session

                        // place the user into the model HashMap


                        // return a ModelAndView for the messages template



                        // IF NOT:
                        // return a ModelAndView for the index template


                },
                new MustacheTemplateEngine()
        );

        Spark.post(
                "/create-user",
                (request, response) -> {

                    // get the loginName value from the request's queryParams

                    // create a new instance of a User for the loginName

                    // Add the user into the session

                    // Redirect to /

                    // halt the request

                    // return an empty string

                }
        );

        Spark.post(
                "/create-message",
                (request, response) -> {
                    // get the user from the session

                    // get the submitted message text from the request's queryParams

                    // Create a new message for submitted message text

                    // add the new message to the user's array of messages

                    // redirect to the webroot, /

                    // halt this request

                    // return an empty string

                }
        );
    }


}
