-------------------------------------------
ソースのインストール方法
-------------------------------------------
このコードは、Minecraft Forgeのインストール方法に従います。 
バニラのMCPソースコードへの小さなパッチが適用されます。
成功したMODを構築するために必要なデータとメゾットのいくつかを示します。

また、パッチは "改ざんされていない" MCPソースコード(aka
srgnames) - これはあなたがそれらを直接通常のコードを読むことができないことを意味します。


ソースパックのインストール情報:

基本的なソースのインストール
==============================

より詳細な手順については、Forgeのオンラインマニュアル(英語)を参照してください:
http://mcforge.readthedocs.io/en/latest/gettingstarted/

Step 1: コマンドラインを開き、zipファイルを解凍したフォルダに移動します。

Step 2: ダウンロードしたファイルが置かれたフォルダにコマンドウィンドウが表示されたら、次のように入力します。:

Windowsの場合、">gradlew setupDecompWorkspace"
Linux/Mac OS: "$./gradlew setupDecompWorkspace"

Step 3: Eclipseの場合、 "gradlew eclipse" を叩いてください(Linux Macの場合"./gradlew eclipse" )

IntelliJを使用したい場合は、手順が少し異なります。
1. Open IDEA, and import project.
1, IDEAを開き、"プロジェクトをインポート"をクリックします。
2. build.gradleファイルを選択してインポートします。
3. 完了したら、IntelliJを閉じて次のコマンドを実行してください:

"gradlew genIntellijRuns" (./gradlew genIntellijRuns)

Step 4:Eclipseを利用する場合、最後に、Eclipseを開き、ワークスペースを./eclipseに切り替えてください。

あなたのIDEにライブラリがない場合や、問題が発生した場合は、
 "gradlew --refresh-dependencies"を実行してローカルキャッシュをリフレッシュすることができます。
 "gradlew clean"を実行してすべてをリセットしてください。これはコードには影響しません。

それでも動作しない場合や、
gradle環境の詳細については、EsperNet氏の#ForgeGradleを参照してください。

Tip:
マインクラフトのソースコードを気にしない場合は、 
"setupDecompWorkspace"を次のいずれかに置き換えることができます：
"setupDevWorkspace"：マインクラフトを実行するために必要なアセットをパッチ、収集しますが、人間が読めるソースコードは生成されません。
"setupCIWorkspace"：Devと同じですが、アセットをダウンロードしません。 これは、最小限の作業しか実行できないため、サーバーを構築するのに便利です。

Tip:
Decompワークスペースを使用する場合、Minecraftソースコードは編集可能な方法でワークスペースに追加されません。 
Minecraftは通常のライブラリのように扱われます。 ソースはドキュメンテーションや研究目的のために用意されており、
通常はIDEの '参照ライブラリ'セクションでアクセスできます。

Forgeのソースのインストール
=========================
MinecraftForgeはこのコードを同梱し、Foeの一部としてインストールします
インストールプロセスでは、これ以上の処置は必要ありません。

LexMano氏たちによる動画
=======================
https://www.youtube.com/watch?v=8VEdtQLuLO0&feature=youtu.be

更なることについては、Forge Forumsを参照してください。
http://www.minecraftforge.net/forum/index.php/topic,14048.0.html
