// TOOD: all scripts should be in one page
$(document).on('submit', '#form_done', function (e) {
    //cache the form element for use in this function
    var $this = $(this);

    //prevent the default submission of the form
    e.preventDefault();

    //run an AJAX post request to your server-side script, $this.serialize() is the data from your form being added to the request
    var action = $(this).data("action")
    $.post(action, $this.serialize(), function (responseData) {
        console.log(responseData)
        //in here you can analyze the output from your server-side script (responseData) and validate the user's login without leaving the page
        return false;
    });
    return false;
});

// $('#done-btn').click(function () {
//     $('.check').toggle();
// });


var list = document.querySelector('ul');
list.addEventListener('click', function (ev) {
    if(ev.target.tagName == 'LI') {
        ev.target.classList.toggle('check');
    }
}, false);