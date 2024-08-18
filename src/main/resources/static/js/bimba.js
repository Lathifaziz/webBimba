function toglePasswordVisibility() {
   let password = document.getElementById("pwd1");
   let requirePassword = document.getElementById("pwd")
   let checkPassword = document.getElementById("check1");

   if (checkPassword.checked) {
      password.type = "text";
      requirePassword.type = "text"
   } else {
      password.type = "password";
   }

}

function edit(element) {
   
   let editField = element.querySelector('.edit-field');
   let editText = element.querySelector('.edit-text');

   editField.style.display = 'inline';
   editField.value = editText.innerText;
   editText.style.display = 'none';

   editField.focus();

   editField.onblur = function () {
      editText.innerText = editField.value;
      editText.style.display = 'inline';
      editField.style.display = 'none';
      
   
   }

   function deleteStudent(id) {
       if (confirm('Are you sure you want to delete this student?')) {
           fetch(`/students/${id}/delete`, {
               method: 'DELETE'
           })
           .then(response => {
               if (response.redirected) {
                   window.location.href = response.url; // Redirect ke halaman yang benar
               } else if (response.ok) {
                   alert('Student deleted successfully.');
                   window.location.reload(); // Reload halaman untuk memperbarui daftar siswa
               } else {
                   alert('Failed to delete student.');
               }
           })
           .catch(error => {
               console.error('Error:', error);
           });
       }
   }


   
}