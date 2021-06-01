
function replaceWithCall(url,method, toReplaceId, data){
    $.ajax({
        method: method,
        url: url,
        data: data,
        context: document.body
    }).done(function(response) {
        $(toReplaceId).html(response);
    });
}

function allPaginatedCall(url, method, toReplaceId, size){
    replaceWithCall(url,method, toReplaceId, {size: size});
}

function onePaginatedPageCall(url, method, toReplaceId, size, page){
    replaceWithCall(url,method, toReplaceId, {size: size, page: page});
}