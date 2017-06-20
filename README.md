#Instrukcja #Projekt

Żeby projekt poprawnie odpalić i developować, jako że korzystać będziemy ze Spring'a po stronie backend'owej oraz Angular2 po stronie frontendowej potrzebne jest wykonanie kilku kroków zanim będzie możliwe poprawne odpalenie apki.

Po pierwsze to IntelliJ'a używajcie a nie Eclipse'a bo tam pewnie problemy same by były. 

1. Potrzebujemy pobranego najnowszego JDK Javy w wersji 8
http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html

2. Potrzebujemy zainstalowanego najnowszego NodeJS (wersja bodajże 7.9.0)
https://nodejs.org/en/

3. Potrzebujemy zainstalowanego najnowszego Angular-CLI
-to samo co punkt wyżej tylko polecenie "npm install -g angular-cli"

4. Odpalamy projekt, standardowo pull'a można walnąć jak potrzeba coś dociągnąć bo ktoś wrzucił, potem w terminalu wpisujemy "npm install", jak się zakończy, odpalamy polecenie "npm start" i jak będzie compiled successfully to można odpalić build'a głównej aplikacji.

5.Całość defaultowo w przeglądarce można będzie obejrzeć pod adresem http://localhost:4200


####### SZYBKIE OBJAŚNIENIE STRUKTURY #######

Jeśli coś chcecie więcej wiedzieć niż to co niżej napiszę, to po prostu do mnie piszcie na priv / na uczelni zapytajcie.

-pom.xml jest w głównym folderze projektu (większość wie na pewno o co chodzi z tym plikiem, a jak ktoś nie wie to niech doczyta ^^)

-plik application.properties znajduje się tu -> /src/main/resources
-wszystko związane z backendem znajduje się tu -> /src/main/java/Application
-jest tam już stworzony (moim zdaniem) w miarę uporządkowany schemat folderów przeznaczonych na konkretne klasy (controlery, modele, dto, repozytoria, serwisy, configi)
-klasa Application.java odpowiada za odpalenie całej apki backendowej

-cały silnik frontendu znajduje się tu -> /src/app
-w przyszłości jak zechcemy wystawić to na zewnętrzny serwer, żeby nie odpalać lokalnie przy oddawaniu projektu użyjemy ng-build'a, a póki co jest to cała ta odrębna część, którą startujemy za pomocą "npm start"
-jeżeli potrzebujecie dodać jakieś dodatki/pluginy cokolwiek na frontend to robi się to z poziomu terminala w IntelliJ wpisując coś w stylu "npm install <package_name> --save" gdzie "package_name" to nazwa pakietu jaki potrzebujemy. (wszystko da się znaleźć w necie)
-główny plik frontu dla Angular2 to -> /src/app/app.component.html - tutaj znajdzie się cały nasz front (WAŻNE, PATRZ NASTĘPNY PUNKT)
-poczytajcie o Angular2 i jak się go używa, a w szczególności też warto ogarnąć kwestie typu routerLink bo za jego pomocą najwygodniej będzie robić przechodzenie po ekranach frontu.
-w pliku /src/app/app.component.ts będzie dodany Router, który umożliwi funkcjonalność z powyższego punktu
-powstać musi też plik /src/app/app.routing.ts który zapewni wszystkie routy po naszej aplikacji.

-w /src/app znajdują się także dodatkowe foldery dla uporządkowania wszystkiego.

*components - tutaj powinny powstać dla każdego ekranu frontowego po min. 3 pliki:
1) nazwa_ekranu.component.html - zawierający jak nazwa wskazuje kod HTML ekranu
2) nazwa_ekranu.component.ts - plik typescriptowy tzn. plik zawierający Angularową implementację ekranu
3) index.ts - plik zawierający wpis "export * from './nazwa_ekranu.component';"

*_services - tutaj powinny powstać pliki serwisów czyli Angularowa implementacja z zapytaniami typu POST i GET pod odpowiednie adresy kontrolerów backend'owych (nazewnictwo plików dla ujednolicenia: "nazwa_ekranu.service.ts")

*_models -  tutaj powinny powstać pliki modeli wraz z constructorem(odpowiedniki plików modeli z backendu ale napisane pod Angulara czyli typescriptem)

No...to w sumie byłoby na tyle. Sam muszę doczytać trochę o Angular2 bo jeszcze nie mam pełnej wiedzy o nim.







# PrzychodniaClient

This project was generated with [angular-cli](https://github.com/angular/angular-cli) version 1.0.0-beta.28.3.

## Development server
Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive/pipe/service/class/module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `-prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).
Before running the tests make sure you are serving the app via `ng serve`.

## Deploying to GitHub Pages

Run `ng github-pages:deploy` to deploy to GitHub Pages.

## Further help

To get more help on the `angular-cli` use `ng help` or go check out the [Angular-CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
