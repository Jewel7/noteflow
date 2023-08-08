# Noteflow

**Noteflow** is a conversation-based notes application.

## Features

- In a typical **conversation**, there is only one participant: the user.
- The user assumes the role of both the **questioner** and the **responder**.
- In the conversation, the user can send a question as the questioner.
  The user can then answer the question as the
  responder.
- Users have the abilty to edit both the questions and responses once they have been submitted to the conversation.
- Only one question can be submitted at a time, but multiple responses can answer that question.
- Users can maintain multiple conversations, which can function as different topics.
  For example, conversations may be labeled "Biology Notes," "Chemistry Lecture," "New York Trip 2023."
- Users can search for conversations. Within conversations, users can search specific questions and responses.

  
## Endpoints

- 

## Data Transfer Object Models
```json
{
	"questions": [{
		"questionId": 1,
		"questionTitle": "",
		"tags": ["", "", ""],
		"responses": [{
			"responseId": 1,
			"responseText": "",
			"responseLink": ["", "", ""]
		}]

	}]
}
```
