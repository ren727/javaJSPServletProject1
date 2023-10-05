$(document).ready(function () {
  // Function to show the message
  function showMessage(message, buttonText, buttonCallback) {
    var messageDiv = $("<div>").addClass("message").text(message);

    // Create a button and attach a click event handler
   
    // Create a button and attach a click event handler
    var button = $("<button>")
      .addClass("learn-more-button")
      .text(buttonText) // Add "learn-more-button" class
      .css({
        // Apply the button styles here
        background: "linear-gradient(#4dc2f8, #0d82b9)",
        border: "2px solid #0d82b9",
        borderRadius: "10px",
        color: "#e8f8ff",
        padding: "10px 20px",
        cursor: "pointer",
        transition: "background 0.3s, transform 0.3s",
      });
      
    button.hover(
      function () {
        $(this).css({
          background: "#61ccfd",
        });
      },
      function () {
        $(this).css({
          background: "linear-gradient(#4dc2f8, #0d82b9)",
        });
      }
    );
    
    
    
    button.click(buttonCallback);

    messageDiv.append(button);

    $(".message-container").empty().append(messageDiv); // Clear previous messages and add the new one

    setTimeout(function () {
      messageDiv.addClass("hide-rotate"); // Add the 'hide-rotate' class for rotation animation
      setTimeout(function () {
        messageDiv.remove();
      }, 800); // Adjust the timing to match your animation duration
    }, 3000);
  }

  $(".dropdown").click(function () {
    $(".menu").toggleClass("showMenu");
  });

  $(".menu > li").click(function () {
    var selectedOption = $(this).text().trim();
    $(".dropdown > p").html(selectedOption);
    $(".menu").removeClass("showMenu");

    // Use data attributes to store messages and button configurations
    var options = {
      "Dog": {
        message: "Dog lovers are more lively, energetic, and outgoing.",
        buttonText: "Learn More",
        buttonCallback: function () {
          // Add your logic to navigate to the next page for dogs
          window.location.href = "dog-page.html"; // Replace with your dog page URL
        },
      },
      "Cat": {
        message: "Cat lovers value independence and self-reliance.",
        buttonText: "Learn More",
        buttonCallback: function () {
          // Add your logic to navigate to the next page for cats
          window.location.href = "cat-page.html"; // Replace with your cat page URL
        },
      },
      // Add more options as needed
      "Bird": {
        message: "Bird lovers appreciate the beauty and freedom of birds.",
        buttonText: "Learn More",
        buttonCallback: function () {
          // Add your logic to navigate to the next page for cats
          window.location.href = "bird-page.html"; // Replace with your cat page URL
        },
      },
      "Hamster": {
        message: "Hamster lovers prefer small, low-maintenance pets.",
        buttonText: "Learn More",
        buttonCallback: function () {
          // Add your logic to navigate to the next page for cats
          window.location.href = "hamster-page.html"; // Replace with your cat page URL
        },
      },
      "Rabbit": {
        message: "Rabbit lovers are fascinated by the mysteriousness and Peter Rabbit.",
        buttonText: "Learn More",
        buttonCallback: function () {
          // Add your logic to navigate to the next page for cats
          window.location.href = "rabbit-page.html"; // Replace with your cat page URL
        },
      },
    };

    // Display the message and button based on the selected option
    var optionConfig = options[selectedOption] || {
      message: "Thanks for your selection",
      buttonText: "OK",
      buttonCallback: function () {
        // Do nothing or add custom logic
      },
    };
    showMessage(optionConfig.message, optionConfig.buttonText, optionConfig.buttonCallback);
  });
});
