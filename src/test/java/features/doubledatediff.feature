Feature: calculate double date difference

  Scenario Outline: client makes call to GET /doubledatediff
    When the client calls /doubledatediff with "<date1>" and "<date2>"
    Then the client receives status code of 200
    Then the client receives the double date difference as "<expectedDate>"

    Examples:
    | date1      | date2      | expectedDate  |
    | 2018-01-01 | 2018-01-01 | 2018-01-01    |
    | 2018-01-01 | 2018-01-02 | 2018-01-03    |
    | 2018-01-01 | 2018-01-17 | 2018-02-02    |
