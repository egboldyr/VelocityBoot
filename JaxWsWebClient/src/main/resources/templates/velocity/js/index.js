function createNewContact(event) {
    jQuery.ajax({
        type: 'POST',
        url: '/new_contact',
        data: {
            name:    jQuery("#name").val(),
            surname: jQuery('#surname').val(),
            phone:   jQuery('#phone').val(),
            email:   jQuery('#email').val()
        },
        success: function () {
            event.preventDefault();
        },
        error: function (jqXhr, textStatus, errorThrown) {
            console.log( errorThrown );
        }
    });
}