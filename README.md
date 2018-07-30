The program is in three steps:
1) Determine all the tags
2) Use the tags to create the output string.
3) Return the string to the caller

This code works for all the visible tests and 5 of the 7 hidden tests.

1) Determine all the tags
  
  This is done in lines 8 - 32. It assumes no extra white space and the tags, 
  especially img have only a space (no tabs, etc)
  
  Commented out in lines 33-41 is an alternate way of determining that tags
  that takes substrings starting at "<" and ending with ">" and
  stores that actual string for later procesing.
  
  Both methods have given identical results.
  
2) Process all the tags
  Processing the tags is done recursively by iterating through the tags from 
  step 1, using the method "Process". It assumes the html is well formed and 
  therefore starts with "<div>", "<p>", "<b>", or "<img />".  The corresponding 
  Luna text is added to the StringBuilder object, which will be converted to 
  a String at the end.
  
  The next tag is read. If it is a normal end tag, then "])" is appended and 
  the function returns. If it is another (start) tag, then it is determined 
  whether to add ", " or not. Note that <img /> tags do not require the comma syntax.
  This new tag is then used to call the Process method again (recursively).
