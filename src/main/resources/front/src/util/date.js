import moment from 'moment'

export const format = (date) => {
  return moment(date).format("YYYY-MM-DD")
};
