package org.example.day9;

public class Day9Note {
    /*
    1. Spring MVC （model - view - controller）
        Model
        View
        Controller
        DispatcherServlet


        Spring boot
        Spring Boot is a framework designed to simplify the development of new Spring applications.
        Why?
        Auto-configuration
        Dependency management - starter
        Embedded server - Tomcat(default)
        Annotation based
        REST API design
        Request method:
        Put(not safe, idempotent, not cacheable) =>  update existing resource or create new
        Get(safe, idempotent, cacheable)
        Delete(not safe, idempotent, not cacheable)
        Patch(not safe, not idempotent(can be), not cacheable) => partially update
        Post (not safe, not idempotent, not cacheable) => create a new resource or submit data
            HTTP Status:
        200 Success
        201 Created
        202 accepted
        204 no content
        301 permanent redirect
        307 temperately redirect
        400 client-side bad requests
        401 unauthorized
        403 forbidden
        404 no found
        500 internal error
            Url design:
                Get: 	/tickets		get all the tickets
                Get:	/tickets/id	retrieve a specific ticket
        Post: 	/tickets		create
        Put:	/tickets/id	update
        Patch:	/tickets/id	partially update
        Delete:	/tickets/id	delete

        Get:	/tickets/id/message	get all the message or a specific tickets
        Get:	/tickets/tid/messages/mid
        Post: 	/tickets/tid/messages
        Put: 	/tickets/tid/messages/mid
        Patch:	/tickets/tid/messages/mid
        Delete:/tickets/tid/messages/mid

        Filter get: 	/tickets?state=close
        Sorting get 	/tickets?sort=priority.created_at
        Search get	/tickets?q=java
        Spring boot rest:
        @RequestBody: 	json -> java object
        @ReponseBody:	java object -> json
        @Controller VS @RestController
            @Controller
        handle web requests and return views
        use ViewResolver to resolve views
        Typically HTML or other view types
                @RestController
        Handle RESTFul web services and return data
        No ViewResolver
        Typically JSON or XML
                @Service
        @Repository
        @PutMapping,@GetMapping,@PostMapping,@PatchMapping,@DeleteMapping
        Annotation
        HTTP Method
        Use Case
        @GetMapping
        GET
        Retrieve resources or data
        @PostMapping
        POST
        Create new resources
        @PutMapping
        PUT
        Update existing resources
        @PatchMapping
        PATCH
        Partially update resources
        @DeleteMapping
        DELETE
        Delete resources


        @PathVariable, @RequestParam,@ResponseEntity,

     */
}
