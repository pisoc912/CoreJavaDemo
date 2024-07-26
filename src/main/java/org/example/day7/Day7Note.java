package org.example.day7;

public class Day7Note {
    /*
     1. OSI Model and TCP/IP Model
        Open System Interconnection, 7 layer

        - application layer
        - presentation layer
        - session layer
        - transport layer
        - network layer
        - data link layer
        - physical layer

        TCP/IP Model => 4 layers

        - Application layer
        - Transport layer
        - Internet layer
        - Network access layer

        HTTP (Hypertext Transfer Protocol)

        - Client-Server model
        - Request
            header/body

        - Response
            header/body

        - HTTP Method
        Get: retrieve some data from the server
            ( safe | idempotent | cacheable(only))
        Post: create new data
            not safe
            not idempotent: Each post request can result in the different outcome or change it in the server’s state
            Not cacheable
        Delete: remove data
            Not safe
            Idempotent
            Not cacheable
        Put: whole update existing data
            Not safe
            Idempotent: update the same entrance every time
            Not cacheable
        Patch: partial update existing data
            Not safe
            Idempotent: update the same entrance every time
            Not cacheable
        HTTP Status code
            - 1xx information
            - 2xx success
                200 OK
                201 Created
                202 Accepted
                204 No Content
            - 3xx redirection
                301 move permanently
                307 temperately redirect
            - 4xx client error
                400 bad request(can not understand request)
                401 Unauthorized
                403 Forbidden
                404 No found
            - 5xx server error
                500 internal server error

        HTTP Advanced
            Safe
            a HTTP method is safe if it doesn’t alter the state of the server
            Idempotent
            a method is idempotent if an identical request can be made once or several times in a row with the same effect while leaving the server in the same state
            Cacheable:
            Whether the response can be cached.

        IOC: inversion of control
        Handle over the creation and management of objects to external systems or frameworks rather than directly controlling them in the code.
        loss of decoupling
        flexibility and scaleable

        Dependency injection -> to achieve IOC
        By separating the object's dependencies from the internal code and injecting these dependencies externally
        Injection method:
        Constructor injection: Dependencies are injected into objects through constructors.
        Setter method injection: Inject dependencies into objects through setter methods.
        Field injection: Inject dependencies directly into fields of objects (usually implemented using a framework, such as Spring).


     */

    public static void main(String[] args) {

    }
}
