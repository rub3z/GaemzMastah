

using System;
using System.Windows.Input;

namespace GaemzMastah.ViewModel
{
    public class RelayCommand : ICommand
    {
        public event EventHandler CanExecuteChanged = (sender, e) => { };
        private Action<object> action;

        public RelayCommand(Action<object> action)
        {
            this.action = action;
        }
        public bool CanExecute(object parameter)
        {
            return true;
        }

        public void Execute(object parameter)
        {
            action(parameter);
        }
    }
}
