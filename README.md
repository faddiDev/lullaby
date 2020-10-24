# lullaby

Java data store text
<br>
An API Java Database Text with CRUD<br>
<h2>LOG Change</h2>
<table>
  <tr><td>05 March 2018</td><td>ver 0.5</td><td>lullaby Created</td></tr>
  <tr><td>30 March 2020</td><td>ver 1.0</td><td>added encryption to .txt</td></tr>
</table>
<br><br>
<h1>HOW TO :</h1>
<hr>
<h4>define lullaby instance</h4>
lullaby db = new lullaby("User.txt",6);<br>
<b>User.txt</b> is database tables<br>
<b>6</b> is database column
<br>
<p>Example column :</p>
<p>id,name,address</p> <b>this will be a 3 column tables</b>
<br><br><br>
<p>take a look at this User.txt database, it has 3 column</p>
<table>
  <tr><td>20201</td><td>ani</td><td>mexico</td></tr>
  <tr><td>20202</td><td>ana</td><td>new york</td></tr>
  <tr><td>20203</td><td>adi</td><td>tangerang</td></tr>
</table>
<br>
<h3>selectAll()</h3>
print all query in database<br>
<h5>Usage : </h5>
<code>System.out.println(db.selectAll());</code>

<b><p>it will print :</p>
20201,ani,mexico,<br>
20202,ana,new york<br>
20203,adi,tangerang</b>
<br><br>
<h3>selectWhere(String equal, int where)</h3>
query database selection where your selection is <b>equal</b> and column is <b>where</b><br>
<h5>Usage : </h5>
<code>System.out.println(db.selectWhere("ana",1)[0]);</code>

<b><p>it will print :</p>
20202</b>
<br><br>
<h3>insert(String[] insert)</h3>
<p>insert query into database</p>
<code>String[] arry = {"20204","molly","Bandung"};</code>
<br>
<code>db.insert(array);</code>
<br><br>
<h3>update(String equal, int where, int oldString, String newString)</h3>
update a query in database
<h5>Usage : </h5>
<code>db.update("ana",1,2,"jakarta");</code>

<b><p>it will update ana address from new york into jakarta</p></b>
<br>
<h3>delete(String equal, int where)</h3>
delete a row in database where query is <b>equal</b> and where is column<br>
<h5>Usage : </h5>
<code>db.delete(20203,0);</code>

<b><p>it will delete the entire row of 20203 id</p></b>
<br /><br />
Faddi Susanto&copy;2020
