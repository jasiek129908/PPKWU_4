# PPKWU_4
API used to count character types in given text. It delegates the works of processing text to another server.
It takes two parameters entry format and return format as input. Available options for them: json, xml, csv and txt.
To use API, u need to sent GET method and pass parameter text.
## Syntax
```
apiText/{entry format}/{return format}?text=
```

## All available calls from txt format
```
http://localhost:1235/apiText/txt/csv?text=KaJaK 123..,,
http://localhost:1235/apiText/txt/xml?text=KaJaK 123..,,
http://localhost:1235/apiText/txt/json?text=KaJaK 123..,,
http://localhost:1235/apiText/txt/txt?text=KaJaK 123..,,
```
## Result for entry format txt
Return format as xml
```
<response>
  <specialCharacterCounter>4</specialCharacterCounter>
  <digitCounter>3</digitCounter>
  <textToProcess>KaJaK 123..,,</textToProcess>
  <upperCaseCounter>3</upperCaseCounter>
  <lowerCaseCounter>2</lowerCaseCounter>
  <whiteSpaceCounter>1</whiteSpaceCounter>
</response>
```
Return format as csv
```
specialCharacterCounter,digitCounter,textToProcess,upperCaseCounter,lowerCaseCounter,whiteSpaceCounter
4,3,"KaJaK 123..,,",3,2,1
```
Return format as json
```
{
  "specialCharacterCounter":"4",
  "digitCounter":"3",
  "textToProcess":"KaJaK 123..,,",
  "upperCaseCounter":"3",
  "lowerCaseCounter":"2",
  "whiteSpaceCounter":"1"
}
```
Return format as txt
```
textToProcess: KaJaK 123..,,
upperCaseCounter: 3
lowerCaseCounter: 2
digitCounter: 3
whiteSpaceCounter: 1
specialCharacterCounter: 4
```
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Second API
API used to convert archival data to specific. It takes two parameters entry format and return format as input. Available options for them: json, xml, csv and txt.
To use API, u need to sent GET method and pass request body as text. Request body needs to be in specific format that we pass within from parameter.
## Syntax
```
/api/{from}/{to}
```

## All available calls from txt format
```
http://localhost:1235/api/txt/txt
http://localhost:1235/api/txt/json
http://localhost:1235/api/txt/xml
http://localhost:1235/api/txt/csv
```
## Result for from parameter set as json
# Request body - json object passed as text
```
{
    "textToProcess": "KaJaK 123..,,",
    "upperCaseCounter": 3,
    "lowerCaseCounter": 2,
    "digitCounter": 3,
    "whiteSpaceCounter": 1,
    "specialCharacterCounter": 4
}
```

Return format as txt
```
textToProcess: KaJaK 123..,,
upperCaseCounter: 3
lowerCaseCounter: 2
digitCounter: 3
whiteSpaceCounter: 1
specialCharacterCounter: 4
```

Return format as json
```
{
    "textToProcess": "KaJaK 123..,,",
    "upperCaseCounter": 3,
    "lowerCaseCounter": 2,
    "digitCounter": 3,
    "whiteSpaceCounter": 1,
    "specialCharacterCounter": 4
}
```

Return format as xml
```
<response>
  <specialCharacterCounter>4</specialCharacterCounter>
  <digitCounter>3</digitCounter>
  <textToProcess>KaJaK 123..,,</textToProcess>
  <upperCaseCounter>3</upperCaseCounter>
  <lowerCaseCounter>2</lowerCaseCounter>
  <whiteSpaceCounter>1</whiteSpaceCounter>
</response>
```

Return format as csv
```
specialCharacterCounter,digitCounter,textToProcess,upperCaseCounter,lowerCaseCounter,whiteSpaceCounter
4,3,"KaJaK 123..,,",3,2,1

```



