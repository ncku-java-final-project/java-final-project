# java-final-project

## 簡介

本project為成功大學JAVA軟體開發第三組的final project, 是一個可以用標籤篩選餐廳，然後抽出餐廳的project。同時可以用Google地圖找附近有哪些餐廳。

## 其他資訊

- Java 檔案在 app\src\main\java\com\example\nckujavafinalproject 資料夾中
- 不要clone在有non-ascii字元(如中文)的資料夾中，會無法進行gradle build

## 使用方法

1. `git clone` 這個project
2. 用Android Studio 開啟這個project
3. 在local.properties加入`MAPS_API_KEY={your_api_key}`，用Google Maps API KEY取代`{your_api_key}`
4. 用gradle build這個project
5. 使用emulator/外部連接的手機運行

## 成果預覽

<img src="app\src\main\res\drawable\main_screen.png" alt="main screen" height="500"/>

## 功能

- 資料庫紀錄餐廳與標籤
- 標籤篩選餐廳、抽餐廳
- 搭配Google地圖探索附近餐廳

## 工具/套件

- Android Studio
- Room Database
- Google地圖API

## 組員

- 成大資訊114 王柏凱
- 成大機械114 邱聖佐
- 成大環工112 陳冠佑
