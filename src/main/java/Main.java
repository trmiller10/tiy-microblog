import com.sun.org.apache.xpath.internal.operations.Mod;
import spark.ModelAndView;
import spark.Session;
import spark.*;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

import static spark.Spark.halt;
import static spark.route.HttpMethod.get;

public class Main {
    static User user;

    public static void main(String[] args) {

        Spark.init();

        // TODO: this creates an end-point for the webroot
        Spark.get(
                "/",
                (request, response) -> {

                    // TODO: create a HashMap to hold our model
                    HashMap hashMap = new HashMap();

                    // TODO: check if the session contains an element with a key "user"
                    //HSN: change this to User user = ... .attributes.contains("user");
                    if (request.session().attributes().contains("user")) {

                        // TODO: IF SO:
                        // TODO: get the user from the session
                        // TODO: place the user into the model HashMap
                        hashMap.put("user", request.session().attribute("user"));


                        // TODO: return a ModelAndView for the messages template
                        return new ModelAndView(hashMap, "messages.mustache");

                    }

                    // TODO: IF NOT:
                    // TODO: return a ModelAndView for the index template
                    else {
                        return new ModelAndView(hashMap, "index.mustache");
                    }
                },

                new MustacheTemplateEngine()
        );

        Spark.post(
                "/create-user",
                (request, response) -> {

                    // TODO: get the loginName value from the request's queryParams
                    //String name = request.queryParams("loginName");
                    // TODO: create a new instance of a User for the loginName
                    //User user = new User(name);
                    // TODO: Add the user into the session
                    User user = new User(request.queryParams("loginName"));
                    request.session().attribute("user", user);

                    // TODO: Redirect to /
                    response.redirect("/");

                    // TODO: halt the request
                    halt();

                    // TODO: return an empty string
                    return "";
                }
        );

        Spark.post(
                "/create-message",
                (request, response) -> {

                    // TODO: get the user from the session
                    User user = request.session().attribute("user");

                    // TODO: get the submitted message text from the request's queryParams
                    String submittedMessage = request.queryParams("message");

                    // TODO: Create a new message for submitted message text
                    Message newMessage = new Message(submittedMessage);

                    // TODO: add the new message to the user's array of messages
                    //HSN: User class already has its own Array List for messages, use that one here instead
                    //newMessage.setMessageText(submittedMessage);
                    user.getUserMessage().add(newMessage);

                    // TODO: redirect to the webroot, /
                    response.redirect("/");

                    // TODO: halt this request
                    halt();
                    // TODO: return an empty string

                    return "";
                }
        );

    }


}
