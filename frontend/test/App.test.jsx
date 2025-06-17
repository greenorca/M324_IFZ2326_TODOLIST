import App from "../src/App";
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import { act } from "react";

beforeEach(() => {
  fetch.resetMocks();
})

test('renders ToDo Liste title', async() => {

  fetch.mockResponseOnce(JSON.stringify([
    { id: 1, taskdescription: 'Item1' },
    { id: 2, taskdescription: 'Item2' }])
  );
  await act(async () => {
    render(<App />);
  })

  const item1 = await screen.getByText(/Item1/i);
  expect(item1).toBeInTheDocument()
  expect(item1).toBeVisible()

  const item2 = screen.getByText(/Item2/i);
  expect(item2).toBeInTheDocument()
  expect(item2).toBeVisible()
});