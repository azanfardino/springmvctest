function validateForm() {
    var x = document.forms["search_form"]["textToSearch"].value;
    if (x == null || x.trim().length < 2) {
        document.getElementById('err').innerHTML = 'please insert at least 2 characters'
        return false;
    }
 }
 
 function cleanError(){
	 document.getElementById('err').innerHTML = '';
 }