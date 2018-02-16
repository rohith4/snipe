jQuery(document).ready(function($) {
	
	$('.boxy').boxy({modal: true, closeText: '', closeable: true, draggable: false});
								
	//Show Categories of Drop-Down-Menu
	$('.categoriesHead').click(function() {
		$('#categoriesDropDown').toggle();	
		$('.categoriesHead').toggleClass('categoriesSelected');
		$('.viewAllCategories').toggleClass('hideAllCategories');
	});
	
	//Like a Question or Answer
	$('.likeThisLink').one("click", function() {
		var contentID = $(this).attr("id").split("-")[2];
		var contentType = $("a", this).attr("id").split("-")[1];
		var adminURL = $('.adminURL').attr("id");
		var templateURL = $('.templateURL').attr("id");
		var processURL = adminURL + "admin-ajax.php";
		 $.post(processURL,{
		  action: 'my_unique_action',
		  content_id: contentID,
		  content_type: contentType},  
		  function(data) {  
			var currentLikeCount = $('.likeCount-' + contentID).attr("id").split("-")[1];
			var newLikeCount = parseInt(currentLikeCount) + 1;
			$('#like-this-'+contentID).hide().html("<a><span><img src=\"" + templateURL + "/images/like-icon.png\" alt=\"\" />" + newLikeCount + "</span></a>").slideDown();
			$('.likeCount-' + contentID).attr("id", "likeCountCurrent-" + newLikeCount);
			$('#like-this-'+contentID).removeClass('likeThisLink').addClass('disabledLike');
		  });  
	});
	
	// Hide Modal on Form Submit - DOM 
	$('.process').click(function() {
		$('.hiddenContent').hide();		
		$('.boxy-wrapper').hide();	
		$('.boxy-modal-blackout').hide();
	});
	
	// Submit Edit Profile - Remove Curent Avatar
	$('.removeAvatarImage > a').click(function() {
		$('#remove_user_avatar').val('1');
		$('#editprofile').submit();
	});
	
	// Set cookie Function
	function setCookie(name,value,days) {
		if (days) {
			var date = new Date();
			date.setTime(date.getTime()+(days*24*60*60*1000));
			var expires = "; expires="+date.toGMTString();
		}
		else var expires = "";
		document.cookie = name+"="+value+expires+"; path=/";
	}
	
	// Gather Cookie Data
	function getCookie(name) {
		var nameEQ = name + "=";
		var ca = document.cookie.split(';');
		for(var i=0;i < ca.length;i++) {
			var c = ca[i];
			while (c.charAt(0)==' ') c = c.substring(1,c.length);
			if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
		}
		return null;
	}
	
	// Hide Top Banner Ad - User Controled
	$('.closeAd').click(function() {
		$('.topBannerWrapper').slideUp(500);
		setCookie('rqa_upper_banner_ad', 'hide', '7');
		return false;				 
	});

	//Show - Hide Sign Up Form on Ask Question Page
	$('#showSignUpBox').click(function() {
		$('#loginBox').slideUp(500);						   
		$('#signUpBox').slideDown(500);
		$('#user_type').attr("value", "new");
		return false;				 
	});
	
	//Show - Hide Login Form on Ask Question Page
	$('#showLoginBox').click(function() {
		$('#signUpBox').slideUp(500);
		$('#loginBox').slideDown(500);						   
		$('#user_type').attr("value", "old");
		return false;				 
	});
	
	// Close a Message Box
	$('#closeIcon').click(function() {
		$('.alertMessage').slideUp(500);
	});		
	
	// Toggle Comments Section Open / Close
	$('.togglecomments').click(function() {
	    var contentPanelId = $(this).attr("id");
		var commentSection = '#commentSection' + contentPanelId; 
		var value = $(commentSection).css('display') == 'none';

		if(value == true){
			$(commentSection).slideDown(500);
		} else {
			$(commentSection).slideUp(500);
		}
	});
	
	
	// Toggle Add a Comment Section Open / Close
	$('.toggleaddcommentform').click(function() {
	    var commentFormId = $(this).attr("id");
		var commentForm = '#commentForm' + commentFormId; 
		var value = $(commentForm).css('display') == 'none';

		if(value == true){
			$(commentForm).slideDown(500);
		} else {
			$(commentForm).slideUp(500);
		}
	});
		
});



// Tabs Function
function getElementsByClass(objArea, thisTag, thisClass) {
	var obj = document.getElementById(objArea).getElementsByTagName(thisTag);
	var arrElements = new Array();
	for (i = 0; i < obj.length; i++) {
		if(obj[i].className == thisClass) {
			arrElements[arrElements.length] = obj[i]
		}
	}
	return arrElements;
}

// Tabs Function Show the sections
function showWidget(tab,objNum) {
	var objTab = document.getElementById("wTabs" + objNum);
	objTab = objTab.getElementsByTagName("li");
	var objContent = getElementsByClass("tabWidget" + objNum, "div", "wContentBox");
	for (i = 0; i < objTab.length; i++) {
		if (i == tab) {
			objTab[i].className = "on";
			objContent[i].style.display = "block";
		} else {
			objTab[i].className = "";
			objContent[i].style.display = "none";
		}
	}
}