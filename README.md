# 概要
- Java学習成果アウトプット用
- 登録したユーザーは俳句/川柳形式での書き込み(5-7-5)の書き込みができる会員制掲示板
- 他ユーザーの書き込みを閲覧し、1日1回「いいね！」をすることができる
- 匿名書込、ランダム書込対応

# 画面遷移図と簡単な機能説明
![boyaki575](https://user-images.githubusercontent.com/109560795/181430384-be3d03d8-ce0a-4224-9fad-81f2152df408.jpg)

# 構成
| ページ           | URL                | Servlet           | JSP |
| ---              | ---                | ---               | --- |
| ログイン         | /login             | LoginServlet      | login.jsp |
| ログイン完了 | -         | -       | loginDone.jsp |
| ユーザー登録     | /userAdd            | SignupServlet     | userAdd.jsp |
| ユーザー登録完了 | -         | -       | userAddDone.jsp |
| ログアウト       | /logout            | LogoutServlet     | logoutDone.jsp |
| ぼやき一覧 | /boyaki         | BoyakiViewServlet       | boyaki.jsp |
| ぼやき書き込み   | /boyakiWrite   | BoyakiWriteServlet | writeBoyaki.jsp |
| ぼやき書き込み完了   | -    | -  | boyakiWriteDone.jsp |

# 苦労したところ
- [いいね！]ボタンの仕様(1日1回の判定、ボタンを押せないようにする)
- 重複LoginIdをバリデーションで弾く手順
- ランダムぼやき機能(ランダム抽出手順および出力方法)


# 時間の都合で未実装だったもの
- ぼやき検索機能
- ぼやきのページネーション
- デザイン
- ぼやきの編集・削除機能
- ユーザー名変更、ユーザー削除機能
