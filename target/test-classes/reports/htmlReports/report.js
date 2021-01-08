$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/cuke/ShoppingSite.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 19,
  "name": "Logining in",
  "description": "",
  "id": "logining-in",
  "keyword": "Feature"
});
formatter.before({
  "duration": 8437507600,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Search Item",
  "description": "",
  "id": "logining-in;search-item",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "I can access the shopping site",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "I enter the correct info",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "I sign in",
  "keyword": "Then "
});
formatter.match({
  "location": "UserLogin.i_can_access_the_shopping_site()"
});
formatter.result({
  "duration": 2033182800,
  "status": "passed"
});
formatter.match({
  "location": "UserLogin.i_enter_the_correct_info()"
});
formatter.result({
  "duration": 52462990600,
  "status": "passed"
});
formatter.match({
  "location": "UserLogin.i_sign_in()"
});
formatter.result({
  "duration": 22500,
  "status": "passed"
});
formatter.after({
  "duration": 114085400,
  "status": "passed"
});
});