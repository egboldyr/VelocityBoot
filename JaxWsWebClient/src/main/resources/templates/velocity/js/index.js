/*Script для создания нового контакта*/
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

/*Получение всех записей контактов из БД*/
function getAllContacts() {
    jQuery.ajax({
        type: 'GET',
        url: '/all_contacts',
        success: function (response) {
            processContacts(response);
        },
        error: function (jqXhr, textStatus, errorThrown) {
            console.log( errorThrown );
        }
    });
}

function processContacts(result) {
    var contacts    = jQuery.parseJSON(result);
    var tab = document.getElementById("contacts");

    for (var i = 0; i < contacts.length; i++) {
        var row = tab.insertRow();
        row.insertCell(0).innerHTML = contacts[i].id;
        row.insertCell(1).innerHTML = contacts[i].name;
        row.insertCell(2).innerHTML = contacts[i].surname;
        row.insertCell(3).innerHTML = contacts[i].phone;
        row.insertCell(4).innerHTML = contacts[i].email;
    }
}