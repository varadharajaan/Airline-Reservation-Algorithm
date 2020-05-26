[![CircleCI](https://circleci.com/gh/varadharajaan/airline.svg?style=svg)](https://circleci.com/gh/varadharajaan/airline)

STEPS TO RUN THE APPLICATION:

1). exceute command -> ./gradlew clean build <br />
2). you can verify the output is print in the file output.txt<br />
3). can give custom input from test case file <br />
4). Also can verify using /swagger-ui.html <br />

REQUEST :
 {
  "passenger": 30,
  "seat": "[[3,2],[4,3],[2,3],[3,4]]"
}

RESPONSE:

19 25 01   02 26 27 03   04 05   06 28 20   
21 29 07   08 30 xx 09   10 11   12 xx 22   
           13 xx xx 14   15 16   17 xx 23   
                                 18 xx 24   
                                 
