$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/com/jet/framework/test/Features/01_AddNewPost.feature");
formatter.feature({
  "name": "Add_A_New_Post",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Add a new post",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AddPost"
    }
  ]
});
formatter.step({
  "name": "I create a new payload",
  "keyword": "Given ",
  "rows": [
    {
      "cells": [
        "UserId",
        "Title",
        "Body"
      ]
    },
    {
      "cells": [
        "\u003cUserId\u003e",
        "\u003cTitle\u003e",
        "\u003cBody\u003e"
      ]
    }
  ]
});
formatter.step({
  "name": "I send \"AddPostAPI\" with \"POST\" http request",
  "keyword": "When "
});
formatter.step({
  "name": "The API call is successfull with status code \"\u003cstatusCode\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "verify \"id\" in response body is \"\u003cid\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "verify \"title\" in response body is \"\u003cTitle\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "verify \"body\" in response body is \"\u003cBody\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "verify \"userId\" in response body is \"\u003cUserId\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "id",
        "statusCode",
        "UserId",
        "Title",
        "Body"
      ]
    },
    {
      "cells": [
        "101",
        "201",
        "1",
        "foo",
        "bar"
      ]
    },
    {
      "cells": [
        "101",
        "201",
        "123",
        "Create a new post",
        "This is an awesome !"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Add a new post",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AddPost"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I create a new payload",
  "rows": [
    {
      "cells": [
        "UserId",
        "Title",
        "Body"
      ]
    },
    {
      "cells": [
        "1",
        "foo",
        "bar"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "CommonStepDefs.createPayload(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I send \"AddPostAPI\" with \"POST\" http request",
  "keyword": "When "
});
formatter.match({
  "location": "CommonStepDefs.createResource(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The API call is successfull with status code \"201\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonStepDefs.statusCodeverify(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify \"id\" in response body is \"101\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommonStepDefs.idVerify(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify \"title\" in response body is \"foo\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommonStepDefs.idVerify(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify \"body\" in response body is \"bar\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommonStepDefs.idVerify(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify \"userId\" in response body is \"1\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommonStepDefs.idVerify(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a new post",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AddPost"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I create a new payload",
  "rows": [
    {
      "cells": [
        "UserId",
        "Title",
        "Body"
      ]
    },
    {
      "cells": [
        "123",
        "Create a new post",
        "This is an awesome !"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "CommonStepDefs.createPayload(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I send \"AddPostAPI\" with \"POST\" http request",
  "keyword": "When "
});
formatter.match({
  "location": "CommonStepDefs.createResource(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The API call is successfull with status code \"201\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonStepDefs.statusCodeverify(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify \"id\" in response body is \"101\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommonStepDefs.idVerify(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify \"title\" in response body is \"Create a new post\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommonStepDefs.idVerify(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify \"body\" in response body is \"This is an awesome !\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommonStepDefs.idVerify(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify \"userId\" in response body is \"123\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommonStepDefs.idVerify(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});