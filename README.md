# PDFの結合

## はじめに
フォルダにあるpdfファイルを結合して出力するjavaのプログラムです。実行する際は、事前にバックアップを取るなど慎重に扱ってください。

## ソースコード
- MergePDF.java
  - PDFを結合するクラス
- MergePDFApp.java
  - PDFを結合するGUIのフレーム

## 実行方法
### ライブラリのダウンロード
[https://www.apache.org/dyn/closer.lua/pdfbox/3.0.0-RC1/pdfbox-app-3.0.0-RC1.jar](https://www.apache.org/dyn/closer.lua/pdfbox/3.0.0-RC1/pdfbox-app-3.0.0-RC1.jar)からjarファイルをダウンロードする。
### コンパイル
クラスパスを指定してコンパイルする。jarファイルを、このREADME.mdと同じディレクトリに配置した場合は次のコマンドを入力する。
```
javac -classpath .:pdfbox-app-3.0.0-RC1.jar mergepdf/MergePDFApp.java
```
### 実行
クラスパスを指定して実行する
```
java -classpath .:pdfbox-app-3.0.0-RC1.jar mergepdf.MergePDFApp
```

### jarファイルの作成
jarファイルを作成する場合は次のコマンドを入力する。
```
jar -cvf mergepdf.jar mergepdf/*.class
jar -uvfm mergepdf.jar manifest.mf
```
実行
```
java -jar mergepdf.jar
```
