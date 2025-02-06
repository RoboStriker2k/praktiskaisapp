## To download the app
 ```
 git clone https://github.com/RoboStriker2k/praktiskaisapp.git
```
## To set up the angular development
```
cd src/angular/praktiskaisapp
npm install
cd ../../..

```
## To run angular with out endpoints
```
cd src/angular/praktiskaisapp
ng serve
cd ../../..
```

## To build the angular app
```
cd src/angular/praktiskaisapp
npm run build
cd ../../..

```
# the app builds its binaries into path : 
```
src\main\resources\static 
```
### To setup Springboot app with its endpoints
1.  run maven install command
` .\mvnw install `
2. then run 
` .\mvnw  compile`
3. then you can start the springboot app with
` .\mvnw  spring-boot:run -Drun.jvmArguments="-Dfile.encoding=UTF-8" `

## During the development these scripts were used to save time
```
buildscript.bat; compile.bat, compileangular.bat; rerun.bat, rerunonlyangular.bat
```

## Total time used for the project is   28 hours 46 minutes , that is over a few days