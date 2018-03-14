/*Script @Создания нового контакта@*/
function createNewContact(event) {
    jQuery.ajax({
        type: 'POST',
        /*url: '/new_contact',*/                                                               /*SpringBoot Controller*/
        url: '/ws/new',                                                                        /*HttpServlet*/
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

/*Script @Получение всех записей контактов из БД@*/
function getAllContacts() {
    jQuery.ajax({
        type: 'GET',
        /*url: '/all_contacts',*/                                                              /*SpringBoot Controller*/
        url: '/ws/all',                                                                        /*HttpServlet*/
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
    var tab = document.getElementById("contacts_body");

    /*Временный фикс удаления строк, так как пока не нашел альтер вариант*/
   /* var rows = tab.rows;
    for (var i = 0; i < rows.length; i++) {
        tab.deleteRow(i);
    }*/

    /*Добавляем актуальную информацию полученную через AJAX*/
    for (var i = 0; i < contacts.length; i++) {
        var row = tab.insertRow();
        row.insertCell(0).innerHTML = contacts[i].id;
        row.insertCell(1).innerHTML = contacts[i].name;
        row.insertCell(2).innerHTML = contacts[i].surname;
        row.insertCell(3).innerHTML = contacts[i].phone;
        row.insertCell(4).innerHTML = contacts[i].email;
        /*Кнопки Edit и Delete*/
        row.insertCell(5).innerHTML =
            "<div class='input_div'>" +
            "     <input class='input_edit'   type='button' value='Edit'   onclick='editRow(event, this)'>" +
            "     <input class='input_delete' type='button' value='Delete' onclick='deleteRow(event, this)'></div>";

    }
}

/*Script @Изменение контакта@*/
function editRow(event) {
    event.preventDefault();

}

/*Script @Удаление контакта@*/
function deleteRow(event, btn) {
    event.preventDefault();
    /*С амое худшее что можно было придумать, чтобы
     * получить ссылку на строку :(*/
    var row = btn.parentNode.parentNode.parentNode;
    var contactId = row.getElementsByTagName("td")[0].innerHTML;

    jQuery.ajax({
         type: 'POST',
         /*url:  '/delete_contact',*/                                                          /*SpringBoot Controller*/
         url:  '/ws/delete',                                                                   /*HttpServlet*/
         data: {
            id: contactId
         },
         success: function (response) {
             event.preventDefault();
             console.log(response);
         }
    });
    row.parentNode.removeChild(row);
}