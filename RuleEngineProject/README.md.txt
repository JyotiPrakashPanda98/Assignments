# Rule Engine with Abstract Syntax Tree (AST)

## Overview
The Rule Engine with AST is designed to evaluate user eligibility based on attributes such as age, department, income, and experience. It utilizes an Abstract Syntax Tree (AST) to represent conditional rules, enabling dynamic creation, combination, and modification of these rules.

## Features
- **Dynamic Rule Creation**: Users can define rules using a human-readable syntax.
- **Rule Combination**: Multiple rules can be combined into a single AST for efficient evaluation.
- **Eligibility Evaluation**: The system evaluates user attributes against the defined rules, returning eligibility status.
- **Error Handling**: The engine implements robust error handling for invalid rules and data formats.

## Data Structure
The AST is represented by a `Node` class, which contains:
- `type`: Indicates the node type ("operator" for AND/OR, "operand" for conditions).
- `left`: Reference to the left child Node.
- `right`: Reference to the right child Node.
- `value`: Optional value for operand nodes (e.g., number for comparisons).

### Example Rule
- Rule 1: `((age > 30 AND department = 'Sales') OR (age < 25 AND department = 'Marketing')) AND (salary > 50000 OR experience > 5)`
- Rule 2: `((age > 30 AND department = 'Marketing')) AND (salary > 20000 OR experience > 5)`

## Installation
1. **Clone the Repository**:
   ```bash
   git clone <repository_url>



### Instructions to Customize
- **Replace `<repository_url>`**: Add the actual URL of your GitHub repository.
- **Adjust Features and Design Choices**: If you have specific implementations or additional features not covered here, feel free to add them.
- **Test Cases**: Tailor the test cases section to reflect the tests you have implemented.

This `README.md` provides a structured overview of your **Rule Engine with AST**, helping others understand your project, how to set it up, and its functionalities. If you have any specific details or changes in mind, just let me know!


