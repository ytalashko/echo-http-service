## Echo Service

### Notes

* Service listens to requests with any HTTP methods on path `/echo`
* Service listens exactly to path `/echo` (`/echo/` is not acceptable).  
  By any need, handling for trailing slashes can be simply added by 1 code line, using standard `AutoSlash` middleware.
* Service host & port are hardcoded, for real services they should be moved to the `.conf` file.
* Request timeout & logging configurations are skipped, as well as formatting helpers, like `scalafmt`.
* For this task `EchoUtil` holds response handling logic, for real services, handling logic (especially business related)
  should be specified in a separate layer, e.g. service.  
  But this may differ case by case.
* Included a simple test script to run the request against the server.  
  Skipping real test implementation, as it makes this task solving process longer, than just a couple of hours.

### Running Service & Test Script

#### Running Service

**Prerequirements**:
* Installed `sbt`

Take the next steps to run `echo-http-service` service:
1) In the terminal, navigate to the `echo-http-service` directory.
2) Execute the next command in the terminal:
```shell
$ sbt run
```

Application will listen for `/echo` requests at port `9532`.

#### Running Test Script

**Prerequirements**:
* Installed `curl`

Take the next steps to run simple `echo` request:
1) In the terminal, navigate to the `echo-http-service` directory.
2) (Optional) In case script file is not executable, execute the next command in the terminal:
```shell
$ chmod +x run_echo_request.sh
```
3) Execute the next command in the terminal:
```shell
$ ./run_echo_request.sh
```
